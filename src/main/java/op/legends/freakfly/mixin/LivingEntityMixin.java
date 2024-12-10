package op.legends.freakfly.mixin;

import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import op.legends.freakfly.modules.FreakFly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static meteordevelopment.meteorclient.MeteorClient.mc;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "isFallFlying", at = @At("TAIL"), cancellable = true)
    public void recastOnLand(CallbackInfoReturnable<Boolean> cir) {
        FreakFly fakeFly = Modules.get().get(FreakFly.class);

        if ((Object) this == mc.player && fakeFly.isFlying()) {
            cir.setReturnValue(false);
        }
    }
}
