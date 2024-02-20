package kassuk.addon.blackout.utils.villigerroller;

import kassuk.addon.blackout.modules.misc.VillagerRoller;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VillagerEntity.class)
class VillagerInteractMixin {
    @Inject(at = @At("HEAD"), method = "interactMob(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/ActionResult;", cancellable = true)
    public void interactMob(CallbackInfoReturnable<ActionResult> cir) {
        VillagerRoller roller = Modules.get().get(VillagerRoller.class);
        if (VillagerRoller.currentState == VillagerRoller.State.WaitingForTargetVillager) {
            VillagerRoller.currentState = VillagerRoller.State.RollingBreakingBlock;
            roller.rollingVillager = (VillagerEntity) (Object) this;
            roller.info("We got your villager");
            cir.setReturnValue(ActionResult.CONSUME);
            cir.cancel();
        }
//        if(cir.isCancelled()) {
//            roller.info("Canceled on interact mixin");
//        }
    }
}