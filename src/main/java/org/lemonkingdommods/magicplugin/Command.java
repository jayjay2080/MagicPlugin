package org.lemonkingdommods.magicplugin;

import net.minecraft.world.entity.EntityType;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_20_R1.CraftWorld;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Command implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            TestClass pig = new TestClass(EntityType.PIG, ((CraftWorld)((Player) sender).getWorld()).getHandle());
            double x = ((Player) sender).getLocation().x();
            double y = ((Player) sender).getLocation().y();
            double z = ((Player) sender).getLocation().z();

            pig.setPos(x,y,z);
            ((CraftWorld)((Player) sender).getWorld()).getHandle().addFreshEntity(pig);
            return true;
        }
        return false;
    }
}
