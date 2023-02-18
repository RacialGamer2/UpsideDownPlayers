package net.racialgamer.cheese.mixin;

import net.minecraft.util.Formatting;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.render.entity.PlayerModelPart;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.racialgamer.cheese.Init;
import net.racialgamer.cheese.UpsideDownPlayers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({LivingEntityRenderer.class})
public class LivingEntityRendererMixin {
	public LivingEntityRendererMixin() {
	}

	@Redirect(
			method = {"setupTransforms"},
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/render/entity/LivingEntityRenderer;shouldFlipUpsideDown(Lnet/minecraft/entity/LivingEntity;)Z"
			)
	)
	public boolean forceFlipUpsideDownTransForms(LivingEntity entity) {
		if (Init.INSTANCE.isEnabled()) {
			return true;
		} else {
			if (entity instanceof PlayerEntity || entity.hasCustomName()) {
				String string = Formatting.strip(entity.getName().getString());
				if ("Dinnerbone".equals(string) || "Grumm".equals(string)) {
					return !(entity instanceof PlayerEntity) || ((PlayerEntity)entity).isPartVisible(PlayerModelPart.CAPE);
				}
			}

			return false;
		}
	}

	@Redirect(
			method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/render/entity/LivingEntityRenderer;shouldFlipUpsideDown(Lnet/minecraft/entity/LivingEntity;)Z"
			)
	)
	public boolean forceFlipUpsideDown(LivingEntity entity) {
		if (Init.INSTANCE.isEnabled()) {
			return true;
		} else {
			if (entity instanceof PlayerEntity || entity.hasCustomName()) {
				String string = Formatting.strip(entity.getName().getString());
				if ("Dinnerbone".equals(string) || "Grumm".equals(string)) {
					return !(entity instanceof PlayerEntity) || ((PlayerEntity)entity).isPartVisible(PlayerModelPart.CAPE);
				}
			}

			return false;
		}
	}
}
