package soundsbyexample.sbe01_basic_sound;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

/*
* User: Paul Boese aka Aeronica
* Date: Sep 11, 2016
*
* Based on MinecraftByExample by TheGreyGhost and others
* https://github.com/TheGreyGhost/MinecraftByExample
*/
public class ItemBasicSound extends Item
{

    /*
    * The items .lang file identifiers will be in the format of:
    * item.modid:mod_item_unlocalized_name.name=Localized Item Name
    * item.modid:mod_item_unlocalized_name.tooltip=Localized Item Tooltip Description
    */
    public ItemBasicSound(String unlocalizedName)
    {
        setItemName(this, unlocalizedName);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        EnumBasicSounds enumBasicSound = EnumBasicSounds.byMetadata(itemStackIn.getItemDamage());
        if (worldIn.isRemote)
        {
            /* Client Side */
            switch (enumBasicSound)
            {
            case CLIENT_PLAYER_ONLY:
                /* 
                 * Only the player activating this item will hear a sound. 
                 * In this case the SoundCategory.PLAYERS will be used no matter what
                 * category is specified in sounds.json file.
                 * 
                 * playSound(SoundEvent soundIn, float volume, float pitch)
                 * 
                 * The volume and pitch are set to 1F here, but those can be changed as needed.
                 * 
                 * volume range [0.0 - ]
                 * Each division by 2 equals an attenuation of -6dB.
                 * Each multiplicaton with 2 equals an amplification of +6dB.
                 * A value of 0.0 is meaningless with respect to a logarithmic
                 * scale; it is interpreted as zero volume.
                 * 
                 * pitch range [0.5 - 2.0], default 1.0.
                 */
                playerIn.playSound(StartupCommon.soundEventBasicSound, 1F, 1F);
                break;
            default:
                break;
            }
        }  else
        {
            /* Server Side */
            switch (EnumBasicSounds.byMetadata(itemStackIn.getItemDamage()))
            {
            case SERVER_ALL:
                /*
                 * Plays a sound to everyone around this player including the player.
                 * Because we are using the world server playSound method we have to set the SoundCategory. 
                 */
                worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, StartupCommon.soundEventBasicSound, SoundCategory.PLAYERS, 1F, 1F);
                break;
            case SERVER_OTHERS:
                /* 
                 * Plays a sound to everyone except the player using the EntityPlayer playSound method.
                 * It will play using SoundCategory.PLAYERS no matter what
                 * category is set in the sounds.json file.
                 */
                playerIn.playSound(StartupCommon.soundEventBasicSound, 1F, 1F);
                break;
            default:
                break;
            }
        }       
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
    }


    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        tooltip.add(TextFormatting.GOLD + I18n.format(this.getUnlocalizedName(stack) + ".tooltip"));
    }

    /**
     * Set the registry name of {@code item} to {@code itemName} and the unlocalized name to the full registry name.
     *
     * @author Choonster
     * @param item     The item
     * @param itemName The item's name
     */
    public static void setItemName(Item item, String itemName)
    {
        item.setRegistryName(itemName);
        item.setUnlocalizedName(item.getRegistryName().toString());
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        int metadata = stack.getMetadata();
        EnumBasicSounds enumBasicSound = EnumBasicSounds.byMetadata(metadata);
        return super.getUnlocalizedName() + "_" + enumBasicSound.getName();
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        for (EnumBasicSounds enumBasicSound : EnumBasicSounds.values())
        {
            ItemStack subItemStack = new ItemStack(itemIn, 1, enumBasicSound.getMetadata());
            subItems.add(subItemStack);
        }
    }
    public static enum EnumBasicSounds implements IStringSerializable
    {
        CLIENT_PLAYER_ONLY(0, "client_player_only"), 
        SERVER_OTHERS(1, "server_others"), 
        SERVER_ALL(2, "server_all");

        public int getMetadata() {return this.meta;}

        @Override
        public String toString() {return this.varientName;}

        public static EnumBasicSounds byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length) {meta = 0;}
            return META_LOOKUP[meta];
        }

        @Override
        public String getName() {return this.varientName;}

        private final int meta;
        private final String varientName;

        private static final EnumBasicSounds[] META_LOOKUP = new EnumBasicSounds[values().length];

        private EnumBasicSounds(int i_meta, String i_varientName)
        {
            this.meta = i_meta;
            this.varientName = i_varientName;
        }

        static
        {
            for (EnumBasicSounds value : values()) {META_LOOKUP[value.getMetadata()] = value;}
        }
    }

}
