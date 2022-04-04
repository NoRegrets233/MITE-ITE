package net.xiaoyu233.mitemod.miteite.item;

import net.minecraft.*;
import java.util.List;

public class ItemFortifiedAdamantium extends Item {
    public ItemFortifiedAdamantium(int par1) {
        super(par1, Material.adamantium, "fortified_adamantium");
        this.setMaxStackSize(8);
        this.setCreativeTab(CreativeModeTab.tabMaterials);
    }

    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot){
        if(extended_info){
            info.add("");
            info.add(EnumChatFormat.DARK_PURPLE + Translator.getFormatted(("仅可以用来升级秘银装备"), new Object[0]));
        }
    }
}
