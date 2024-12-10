package op.legends.freakfly;

import com.mojang.logging.LogUtils;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.systems.modules.Category;
import net.minecraft.item.Items;
import op.legends.freakfly.modules.FreakFly;
import org.slf4j.Logger;

public class Addon extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();
    public static final Category CATEGORY = new Category("5C", Items.TNT.getDefaultStack());

    @Override
    public void onInitialize() {
        LOG.info("Initializing 5C FreaFly");

        //init
        Modules.get().add(new FreakFly());
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "op.legends.freakfly";
    }
}
