package net.kris.code_exe.mixin;

import org.mozilla.javascript.tools.shell.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Main.class)
public class RhinoMainMixin {

    @Overwrite(remap = false)
    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "true");
        Thread thread = new Thread(() -> Main.exec(args));
        thread.start();
    }
}