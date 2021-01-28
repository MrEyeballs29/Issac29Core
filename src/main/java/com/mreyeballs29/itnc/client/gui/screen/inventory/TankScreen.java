package com.mreyeballs29.itnc.client.gui.screen.inventory;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mreyeballs29.itnc.inventory.TankContainer;
import com.mreyeballs29.itnc.tileentity.TankTileEntity;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fluids.FluidStack;

public class TankScreen extends ContainerScreen<TankContainer> {

	private static final ResourceLocation GUI = new ResourceLocation("itnc", "textures/gui/container/basic_tank.png"); //$NON-NLS-1$ //$NON-NLS-2$

	public TankScreen(TankContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
	}
	
	@Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
        this.renderFluidTooltip(mouseX, mouseY);
    }
	
	/**
	 * @param mouseX  
	 * @param mouseY 
	 */
	protected void renderFluidTooltip(int mouseX, int mouseY) {
		TankTileEntity tank = this.container.getTileEntity();
		if (isPointInRegion(72, 17, 32, 48, mouseX, mouseY)) {
			ITextComponent textComponent = format(tank.getTank().getFluid(), tank.getTank().getCapacity());
			ITextComponent unit = new TranslationTextComponent("unit.forge.fluid"); //$NON-NLS-1$
			this.renderTooltip(textComponent.getFormattedText() + ' ' + unit.getFormattedText(), mouseX, mouseY);
		}
	}
	
	protected static ITextComponent format(FluidStack stack, int max) {
		String s1 = String.format("%,d", Integer.valueOf(stack.getAmount())); //$NON-NLS-1$
		String s2 = String.format("%,d", Integer.valueOf(max)); //$NON-NLS-1$
		ITextComponent component;
		ITextComponent name = stack.getDisplayName();
		component = new StringTextComponent(String.format("%s: %s / %s", name.getFormattedText(), s1, s2)); //$NON-NLS-1$
		return component;
	}
	
	@SuppressWarnings({ "deprecation", "resource" })
	private void drawFluidTexture(FluidStack stack, double x, double y, double width1, double height1) {
		int amount = stack.getAmount();
        if (stack.getFluid() == null || amount <= 0) {
            return;
        }

        ResourceLocation stillTexture = stack.getFluid().getAttributes().getStillTexture();
        AtlasTexture atlas = this.minecraft.getModelManager().getAtlasTexture(PlayerContainer.LOCATION_BLOCKS_TEXTURE);
        TextureAtlasSprite icon = atlas.getSprite(stillTexture);
        int renderAmount = (int) Math.max(Math.min(height1, amount * height1 / 8000), 1);
        int posY = (int) (y + height1 - renderAmount);

        atlas.bindTexture();
        int color = stack.getFluid().getAttributes().getColor();
        float r = ((color >> 16) & 0xFF) / 255f;
        float g = ((color >> 8) & 0xFF) / 255f;
        float b = (color & 0xFF) / 255f;
        GlStateManager.color4f(r, g, b, 1.0F);

        GlStateManager.enableBlend();
        for (int i = 0; i < width1; i += 16) {
            for (int j = 0; j < renderAmount; j += 16) {
                int drawWidth = (int) Math.min(width1 - i, 16);
                int drawHeight = Math.min(renderAmount - j, 16);

                int drawX = (int) (x + i);
                int drawY = posY + j;

                float minU = icon.getMinU();
                float maxU = icon.getMaxU();
                float minV = icon.getMinV();
                float maxV = icon.getMaxV();

                Tessellator tessellator = Tessellator.getInstance();
                BufferBuilder tes = tessellator.getBuffer();
                tes.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
                tes.pos(drawX, drawY + drawHeight, 0).tex(minU, minV + (maxV - minV) * drawHeight / 16F).endVertex();
                tes.pos(drawX + drawWidth, drawY + drawHeight, 0).tex(minU + (maxU - minU) * drawWidth / 16F, minV + (maxV - minV) * drawHeight / 16F).endVertex();
                tes.pos(drawX + drawWidth, drawY, 0).tex(minU + (maxU - minU) * drawWidth / 16F, minV).endVertex();
                tes.pos(drawX, drawY, 0).tex(minU, minV).endVertex();
                tessellator.draw();
            }
        }
        GlStateManager.disableBlend();
        GlStateManager.color4f(1, 1, 1, 1F);
	}

	
	@Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        this.font.drawString(this.title.getFormattedText(), 8.0F, 7.0F, 4210752);
        this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, this.ySize - 96, 4210752);
        this.drawFluidTexture(this.container.getTileEntity().getTank().getFluid(), 72, 17, 32, 48);
    }

	@SuppressWarnings({ "deprecation", "resource" })
	@Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int relX = (this.width - this.xSize) / 2;
        int relY = (this.height - this.ySize) / 2;
        this.blit(relX, relY, 0, 0, this.xSize, this.ySize);
    }

}
