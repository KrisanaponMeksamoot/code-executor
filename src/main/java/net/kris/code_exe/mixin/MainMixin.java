package net.kris.code_exe.mixin;

import org.mozilla.javascript.tools.shell.JSConsole;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.main.Main;

@Mixin(Main.class)
public class MainMixin {
    @Inject(method = "main([Ljava/lang/String;)V", at = @At(value = "HEAD"))
    private static void main(String[] args, CallbackInfo ci) {
        new Thread(() -> {
            System.setProperty("java.awt.headless", "false");
            new JSConsole(new String[0]);
        }).start();
    }
}