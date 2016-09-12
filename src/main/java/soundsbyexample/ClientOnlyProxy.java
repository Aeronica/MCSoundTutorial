/*
** User: Paul Boese aka Aeronica
** Date: Sep 10, 2016
**
** Based on MinecraftByExample by TheGreyGhost and others
** https://github.com/TheGreyGhost/MinecraftByExample
*/
package soundsbyexample;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

/**
 * ClientProxy is used to set up the mod and start it running on normal
 * minecraft. It contains all the code that should run on the client side only.
 * For more background information see here
 * http://greyminecraftcoder.blogspot.com/2013/11/how-forge-starts-up-your-code.
 * html
 */
public class ClientOnlyProxy extends CommonProxy
{
    /**
     * Run before anything else. Read your config, create blocks, items, etc,
     * and register them with the GameRegistry
     */
    public void preInit()
    {
        super.preInit();
        soundsbyexample.sbe90_configuration.StartupClientOnly.preInitClientOnly();
        soundsbyexample.sbe01_basic_sound.StartupClientOnly.preInitClientOnly();
        soundsbyexample.sbe91_creative_tab.StartupClientOnly.preInitClientOnly();
    }

    /**
     * Do your mod setup. Build whatever data structures you care about.
     * Register recipes, send FMLInterModComms messages to other mods.
     */
    public void init()
    {
        super.init();
        soundsbyexample.sbe90_configuration.StartupClientOnly.initClientOnly();
        soundsbyexample.sbe01_basic_sound.StartupClientOnly.initClientOnly();
        soundsbyexample.sbe91_creative_tab.StartupClientOnly.initClientOnly();
    }

    /**
     * Handle interaction with other mods, complete your setup based on this.
     */
    public void postInit()
    {
        super.postInit();
        soundsbyexample.sbe90_configuration.StartupClientOnly.postInitClientOnly();
        soundsbyexample.sbe01_basic_sound.StartupClientOnly.postInitClientOnly();
        soundsbyexample.sbe91_creative_tab.StartupClientOnly.postInitClientOnly();
    }

    @Override
    public boolean playerIsInCreativeMode(EntityPlayer player)
    {
        if (player instanceof EntityPlayerMP)
        {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;
            return entityPlayerMP.interactionManager.isCreative();
        } else if (player instanceof EntityPlayerSP) { return Minecraft.getMinecraft().playerController.isInCreativeMode(); }
        return false;
    }

    @Override
    public boolean isDedicatedServer()
    {
        return false;
    }
}
