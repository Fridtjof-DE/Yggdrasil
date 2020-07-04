package tk.fridtjof.yggdrasil.cmds.time;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import tk.fridtjof.yggdrasil.utils.Templates;

public class MidNightCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Templates.timeCommand(sender, command, args, 18000);

        return false;
    }
}