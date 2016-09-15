/*
* User: Paul Boese aka Aeronica
* Date: Sep 10, 2016
*
* Based on MinecraftByExample by TheGreyGhost and others
* https://github.com/TheGreyGhost/MinecraftByExample
*/
package soundsbyexample;

import net.minecraft.entity.player.EntityPlayer;

/**
 * CommonProxy is used to set up the mod and start it running. It contains all
 * the code that should run on both the Standalone client and the dedicated
 * server. For more background information see here
 * http://greyminecraftcoder.blogspot.com/2013/11/how-forge-starts-up-your-code.
 * html
 */
public abstract class CommonProxy
{

    /**
     * Run before anything else. Read your config, create blocks, items, etc,
     * and register them with the GameRegistry
     */
    public void preInit()
    {
        // read config first
        soundsbyexample.sbe90_configuration.StartupCommon.preInitCommon();
        soundsbyexample.sbe01_basic_sound.StartupCommon.preInitCommon();
        soundsbyexample.sbe02_mod_record.StartupCommon.preInitCommon();
        soundsbyexample.sbe91_creative_tab.StartupCommon.preInitCommon();
    }

    /**
     * Do your mod setup. Build whatever data structures you care about.
     * Register recipes, send FMLInterModComms messages to other mods.
     */
    public void init()
    {
        soundsbyexample.sbe90_configuration.StartupCommon.initCommon();
        soundsbyexample.sbe01_basic_sound.StartupCommon.initCommon();
        soundsbyexample.sbe02_mod_record.StartupCommon.initCommon();
        soundsbyexample.sbe91_creative_tab.StartupCommon.initCommon();
    }

    /**
     * Handle interaction with other mods, complete your setup based on this.
     */
    public void postInit()
    {
        soundsbyexample.sbe90_configuration.StartupCommon.postInitCommon();
        soundsbyexample.sbe01_basic_sound.StartupCommon.postInitCommon();
        soundsbyexample.sbe02_mod_record.StartupCommon.postInitCommon();
        soundsbyexample.sbe91_creative_tab.StartupCommon.postInitCommon();
    }

    // helper to determine whether the given player is in creative mode
    // not necessary for most examples
    abstract public boolean playerIsInCreativeMode(EntityPlayer player);

    /**
     * is this a dedicated server?
     * 
     * @return true if this is a dedicated server, false otherwise
     */
    abstract public boolean isDedicatedServer();
}
