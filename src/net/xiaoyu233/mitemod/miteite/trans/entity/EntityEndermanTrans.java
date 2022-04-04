package net.xiaoyu233.mitemod.miteite.trans.entity;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.util.Configs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EntityEnderman.class)
public class EntityEndermanTrans extends EntityMonster {
   public EntityEndermanTrans(World par1World) {
      super(par1World);
   }

   @Overwrite
   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      int day = this.getWorld() != null ? this.getWorld().getDayOfOverworld() : 0;
      this.getEntityAttribute(GenericAttributes.maxHealth).setAttribute(100.0D + day / 20D);
      this.getEntityAttribute(GenericAttributes.movementSpeed).setAttribute(0.3D);
      this.getEntityAttribute(GenericAttributes.attackDamage).setAttribute(30.0D + day / 20D);
   }

   public EntityDamageResult attackEntityAsMob(Entity target) {
      this.worldObj.setEntityState(this, EnumEntityState.golem_throw);
      EntityDamageResult result = target.attackEntityFrom(new Damage(DamageSource.causeMobDamage(this), (float) this.getEntityAttributeValue(GenericAttributes.attackDamage)));
      if (result != null && result.entityWasKnockedBack()) {
         target.motionY += 0.6D;
      }

      return result;
   }

  /* @Override
   public boolean getCanSpawnHere(boolean perform_light_check) {
      boolean chanceSpawn = false;
      if (this.worldObj.isTheEnd()) {
         chanceSpawn = this.rand.nextInt(100) < Configs.GameMechanics.MobSpawning.END_MAN_SPAWN_CHANCE_END.get();
      }
      return chanceSpawn;
   }

   */
}
