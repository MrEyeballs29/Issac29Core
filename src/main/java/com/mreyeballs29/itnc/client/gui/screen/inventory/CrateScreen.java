package com.mreyeballs29.itnc.client.gui.screen.inventory;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mreyeballs29.itnc.inventory.CrateContainer;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class CrateScreen extends ContainerScreen<CrateContainer> {

	private static ResourceLocation GUI = new ResourceLocation("itnc", "textures/gui/container/generic_5x3.png"); //$NON-NLS-1$ //$NON-NLS-2$
	
	public CrateScreen(CrateContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
	}
	
	@Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }
	
	@Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        this.font.drawString(this.title.getFormattedText(), 8.0F, 7.0F, 4210752);
        this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, this.ySize - 96 + 5, 4210752);
    }

	@SuppressWarnings({ "deprecation", "resource" })
	@Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int relX = (this.width - this.xSize) / 2;
        int relY = (this.height - this.ySize+3) / 2;
        this.blit(relX, relY, 0, 0, this.xSize, this.ySize+3);
    }

}
