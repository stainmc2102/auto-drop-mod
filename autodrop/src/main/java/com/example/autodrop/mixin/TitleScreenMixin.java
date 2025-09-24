package com.example.autodrop.mixin;

import com.example.autodrop.AutoDrop;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.example.autodrop.mixin.ScreenAccessor;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
    @Inject(method = "init", at = @At("TAIL"))
    private void autodrop$addButton(CallbackInfo ci) {
        TitleScreen screen = (TitleScreen) (Object) this;
        ButtonWidget button = ButtonWidget.builder(
                Text.literal("AutoDrop"),
                b -> {
                    MinecraftClient mc = MinecraftClient.getInstance();
                    if (mc.player != null) {
                        mc.player.sendMessage(Text.literal("AutoDrop button clicked!"), false);
                    }
                })
                .dimensions(screen.width / 2 - 50, screen.height / 4 + 120, 100, 20)
                .build();
    ((ScreenAccessor) screen).invokeAddDrawableChild(button);
    }
}
