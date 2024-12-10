package op.legends.freakfly.mixin;

import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.item.FireworkRocketItem;
import op.legends.freakfly.modules.FreakFly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

@Mixin(FireworkRocketItem.class)
public class FireworkRocketItemMixin {

    @ModifyExpressionValue(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isFallFlying()Z"))
    private boolean overrideIsFallFlying(boolean original) {
        FreakFly fakeFly = Modules.get().get(FreakFly.class);

        if (fakeFly.isFlying()) {
            return false;
        }

        return original;
    }
}