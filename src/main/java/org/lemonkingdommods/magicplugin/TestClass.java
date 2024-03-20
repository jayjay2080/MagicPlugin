package org.lemonkingdommods.magicplugin;


import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class TestClass extends Pig implements RangedAttackMob {
    public TestClass(EntityType<? extends Pig> type, Level world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals(); // Call the superclass method to ensure default goals are added

        // Remove the existing pathfinding goals (this doesnt seem to work ._.)
        assert super.goalFloat != null;
        this.goalSelector.removeGoal(super.goalFloat);

        // add pathfinding goals (this works)
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.of(Items.DIAMOND), false));
        this.goalSelector.addGoal(5, new RangedAttackGoal(this, 1.25D, 1, 20.0f));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, true));
    }


    public void performRangedAttack(LivingEntity var1, float var2) {
        double var4 = var1.getEyeY() - 1.100000023841858D;
        double var6 = var1.getX() - this.getX();
        double var8 = var4 - this.getY();
        double var10 = var1.getZ() - this.getZ();
        double var12 = Math.sqrt(var6 * var6 + var10 * var10) * 0.20000000298023224D;
        SmallFireball var3 = new SmallFireball(this.level(), this, var6, var8 + var12, var10);
        this.playSound(SoundEvents.SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level().addFreshEntity(var3);
    }

}
