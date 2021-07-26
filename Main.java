public final class Main extends JavaPlugin {
    private static Main instance;

    public void onEnable() {
        instance = this;
        CommandManager commandManager = new CommandManager();
        commandManager.registerCommands();
    }


    public static Main getInstance() {
        return instance;
    }
}
