package tk.fridtjof.yggdrasil;

public class MSG {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    public static String noPermission = plugin.configManager.messagesFile.getConfig().getString("error.no_permission");
    public static String tooManyArguments = plugin.configManager.messagesFile.getConfig().getString("error.too_many_args");
    public static String incorrectArgument = plugin.configManager.messagesFile.getConfig().getString("error.incorrect_args");
    public static String playerOnly = plugin.configManager.messagesFile.getConfig().getString("error.player_only");

    public static String enterGameMode = plugin.configManager.messagesFile.getConfig().getString("enter.gamemode");
    public static String enterWorld = plugin.configManager.messagesFile.getConfig().getString("enter.world");
    public static String enterValue = plugin.configManager.messagesFile.getConfig().getString("enter.value");
    public static String enterPlayer = plugin.configManager.messagesFile.getConfig().getString("enter.player");
    public static String enterMessage = plugin.configManager.messagesFile.getConfig().getString("enter.message");

    public static String playerNotFound = plugin.configManager.messagesFile.getConfig().getString("not_found.player");
    public static String worldNotFound = plugin.configManager.messagesFile.getConfig().getString("not_found.world");

    public static String heresYourHead = plugin.configManager.messagesFile.getConfig().getString("give.head");
    public static String heresHeadOf = plugin.configManager.messagesFile.getConfig().getString("give.head_others");
    public static String gaveHead = plugin.configManager.messagesFile.getConfig().getString("give.player_head");

    public static String youveBeenHealed = plugin.configManager.messagesFile.getConfig().getString("heal.heal");
    public static String youHealed = plugin.configManager.messagesFile.getConfig().getString("heal.heal_others");

    public static String toggledFly = plugin.configManager.messagesFile.getConfig().getString("toggle.fly-mode");
    public static String youToggledFly = plugin.configManager.messagesFile.getConfig().getString("toggle.fly-mode_others");

    public static String setFlySpeed = plugin.configManager.messagesFile.getConfig().getString("set.fly_speed");
    public static String setWalkSpeed = plugin.configManager.messagesFile.getConfig().getString("set.walk_speed");
    public static String timeSet = plugin.configManager.messagesFile.getConfig().getString("set.time");

    public static String spawnSetTo = plugin.configManager.messagesFile.getConfig().getString("spawn.set_spawn");
    public static String sendToSpawn = plugin.configManager.messagesFile.getConfig().getString("spawn.spawn");
    public static String sendToSpawnOthers = plugin.configManager.messagesFile.getConfig().getString("spawn.spawn_others");
}
