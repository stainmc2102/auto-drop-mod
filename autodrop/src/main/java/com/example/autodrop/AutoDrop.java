package com.example.autodrop;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class AutoDrop implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Đã chuyển logic thêm nút sang mixin
    }
}
