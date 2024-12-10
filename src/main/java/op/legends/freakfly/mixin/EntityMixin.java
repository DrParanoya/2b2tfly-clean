package op.legends.freakfly.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import op.legends.freakfly.modules.FreakFly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static meteordevelopment.meteorclient.MeteorClient.mc;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @ModifyReturnValue(method = "getPose", at = @At("RETURN"))
    private EntityPose modifyGetPose(EntityPose original) {
        if ((Object) this != mc.player)
            return original;

        FreakFly fakeFly = Modules.get().get(FreakFly.class);
        if (original == EntityPose.FALL_FLYING && fakeFly.isFlying()) {
            return EntityPose.STANDING;
        }
        return original;
    }
}
