package soundsbyexample.sbe01_basic_sound;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

/*
** User: Paul Boese aka Aeronica
** Date: Sep 11, 2016
**
** Based on MinecraftByExample by TheGreyGhost and others
** https://github.com/TheGreyGhost/MinecraftByExample
*/
public class StartupClientOnly
{
    public static void preInitClientOnly()
    {
      // required in order for the renderer to know how to render your item.
      ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("soundsbyexample:sbe01_item_basic_sound", "inventory");
      final int DEFAULT_ITEM_SUBTYPE = 0;
      ModelLoader.setCustomModelResourceLocation(StartupCommon.itemBasicSound, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
    }

    public static void initClientOnly()
    {
    }

    public static void postInitClientOnly()
    {
    }
}
