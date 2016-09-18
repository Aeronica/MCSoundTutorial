package soundsbyexample.sbe01_basic_sound;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import soundsbyexample.SoundsByExample;

/*
* User: Paul Boese aka Aeronica
* Date: Sep 11, 2016
*
* Based on MinecraftByExample by TheGreyGhost and others
* https://github.com/TheGreyGhost/MinecraftByExample
*/
public class StartupClientOnly
{
    public static void preInitClientOnly()
    {
        // required in order for the renderer to know how to render your item.
        sbe01VarientItemRegister();
    }

    private static void sbe01VarientItemRegister()
    {
        String sbe01ItemModelName = "sbe01_item_basic_sound_model";
        for (ItemBasicSound.EnumBasicSounds e : ItemBasicSound.EnumBasicSounds.values())
        {
            ModelLoader.setCustomModelResourceLocation(StartupCommon.itemBasicSound, e.getMetadata(),
                    new ModelResourceLocation(new ResourceLocation(SoundsByExample.prependModID(sbe01ItemModelName) + "_" + e.getName()), "inventory"));
        }
    }

    public static void initClientOnly()
    {
    }

    public static void postInitClientOnly()
    {
    }
}
