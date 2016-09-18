package soundsbyexample;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/*
* User: Paul Boese aka Aeronica
* Date: Sep 10, 2016
*
* Based on MinecraftByExample by TheGreyGhost and others
* https://github.com/TheGreyGhost/MinecraftByExample
*/
//@Mod(modid = SoundsByExample.MODID, version = SoundsByExample.VERSION, guiFactory = SoundsByExample.GUIFACTORY)
@Mod(modid = SoundsByExample.MODID, version = SoundsByExample.VERSION)
public class SoundsByExample
{
    // you also need to update the modid and version in two other places as
    // well:
    // build.gradle file (the version, group, and archivesBaseName parameters)
    // resources/mcmod.info (the name, description, and version parameters)
    public static final String MODID = "soundsbyexample";
    public static final String VERSION = "0.0.1";

    public static final String GUIFACTORY = "soundsbyexample.sbe90_configuration.SBEGuiFactory";

    // The instance of your mod that Forge uses. Optional.
    @Mod.Instance(SoundsByExample.MODID)
    public static SoundsByExample instance;

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide = "soundsbyexample.ClientOnlyProxy", serverSide = "soundsbyexample.DedicatedServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();
    }

    /**
     * Prepend the name with the mod ID, suitable for ResourceLocations such as
     * textures.
     * 
     * @param name
     * @return eg "soundsbyexample:myblockname"
     */
    public static String prependModID(String name)
    {
        return MODID + ":" + name;
    }
}
