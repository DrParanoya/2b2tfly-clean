package op.legends.freakfly.mixin;

import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.client.input.Input;
import net.minecraft.client.input.KeyboardInput;
import op.legends.freakfly.modules.FreakFly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyboardInput.class)
public abstract class KeyboardInputMixin extends Input {
    @Inject(method = "tick", at = @At("TAIL"))
    private void isPressed(boolean slowDown, float f, CallbackInfo ci) {
        if (Modules.get().get(FreakFly.class).isFlying()) sneaking = false;
    }
}