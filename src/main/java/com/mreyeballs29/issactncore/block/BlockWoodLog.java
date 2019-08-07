package com.mreyeballs29.issactncore.block;

import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

public class BlockWoodLog extends BlockLog {

	public BlockWoodLog() {
		setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, EnumAxis.Y));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {LOG_AXIS});
	}
	
    public int getMetaFromState(IBlockState state)
    {
        switch ((BlockLog.EnumAxis)state.getValue(LOG_AXIS))
        {
            case X:
                return 1;
            case Z:
                return 2;
            case NONE:
            	return 3;
            default:
            	return 0;
        }
    }
    
    public IBlockState getStateFromMeta(int meta)
    {
    	if (meta == 1) {
    		return this.getDefaultState().withProperty(LOG_AXIS, EnumAxis.X);
    	} else if (meta == 2) {
    		return this.getDefaultState().withProperty(LOG_AXIS, EnumAxis.Z);
    	} else if (meta == 3) {
    		return this.getDefaultState().withProperty(LOG_AXIS, EnumAxis.NONE);
    	}
        return this.getDefaultState();
    }
}
