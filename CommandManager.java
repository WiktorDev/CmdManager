public class CommandManager {

    public static final HashMap<String, Command> commands = new HashMap();
    private static final Reflection.FieldAccessor<SimpleCommandMap> f = Reflection.getField(SimplePluginManager.class, "commandMap", SimpleCommandMap.class);
    private static CommandMap cmdMap;
    private Main main;

    private void register(Command cmd) {
        if (cmdMap == null) {
            cmdMap = (CommandMap)f.get(Bukkit.getServer().getPluginManager());
        }
        cmdMap.register(cmd.getName(), cmd);
        commands.put(cmd.getName(), cmd);
    }
    public Command getCommand(String command) {
        return (Command)commands.get(command);
    }
    public void unregisterAll() {
        Iterator var1 = commands.keySet().iterator();

        while(var1.hasNext()) {
            String cmd = (String)var1.next();
            this.getCommand(cmd).unregister((CommandMap)f.get(Bukkit.getServer().getPluginManager()));
        }
    }
    public void registerCommands() {
        this.unregisterAll();
        this.register(new ExampleCmd());
    }
    static {
        cmdMap = (CommandMap)f.get(Bukkit.getServer().getPluginManager());
    }
}
