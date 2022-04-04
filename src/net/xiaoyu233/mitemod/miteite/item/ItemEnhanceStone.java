package net.xiaoyu233.mitemod.miteite.item;

import net.minecraft.IIcon;
import net.minecraft.Item;
import net.minecraft.Material;
import net.xiaoyu233.mitemod.miteite.util.Constant;

public class ItemEnhanceStone extends Item {
    public enum Types{
        iron(25, Material.iron),
        mithril(45, Material.mithril),
        adamantium(55, Material.adamantium),
        universal(40, Material.glowstone);
        private final int failChance;
        private IIcon iIcon;
        private final Material material;

        Types(int failChance, Material material) {
            this.failChance = failChance;
            this.material = material;
        }
    }

    private final Types type;

    public ItemEnhanceStone(Types type){
        super(Constant.getNextItemID(), "enhance_stone/" + type.name());
        this.setMaterial(type.material);
        this.type = type;
    }

    public int getFailChance(){
        return this.type.failChance;
    }
}
