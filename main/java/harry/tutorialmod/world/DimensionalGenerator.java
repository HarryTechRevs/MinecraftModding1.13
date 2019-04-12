package harry.tutorialmod.world;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.IChunkGenSettings;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.CompositeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.BasePlacement;
import net.minecraft.world.gen.placement.IPlacementConfig;

public class DimensionalGenerator<F extends IFeatureConfig, P extends IPlacementConfig> extends CompositeFeature<F, P>
{
	private final DimensionType dimension;
	
	public DimensionalGenerator(Feature<F> feature, F featureConfig, BasePlacement<P> basePlacement, P placementConfig, DimensionType dimension) 
	{
		super(feature, featureConfig, basePlacement, placementConfig);
		this.dimension = dimension;
	}
	
	@Override
	public boolean func_212245_a(IWorld world, IChunkGenerator<? extends IChunkGenSettings> p_212245_2_, Random p_212245_3_, BlockPos p_212245_4_, NoFeatureConfig p_212245_5_) 
	{
		if(world.getDimension().getType().equals(dimension))
		{
			return super.func_212245_a(world, p_212245_2_, p_212245_3_, p_212245_4_, p_212245_5_);
		}
		
		return false;
	}
}
