package kassuk.addon.blackout.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.commands.Command;
import net.minecraft.command.CommandSource;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

/**
 * @author KassuK
 */

public class ricinGit extends Command {
    public ricinGit() {
        super("Ricininfo", "gives out info of ricin");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(context -> {
            info("https://discord.com/invite/FDNay74pee/");
            return SINGLE_SUCCESS;
        });
    }
}
