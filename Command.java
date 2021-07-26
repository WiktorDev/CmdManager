public abstract class Command extends org.bukkit.command.Command {
    private final String name;
    private final String usage;
    private final String desc;
    private final String permission;

    public Command(String name, String desc, String usage, String permission, String... aliases) {
        super(name, desc, usage, Arrays.asList(aliases));
        this.name = name;
        this.usage = usage;
        this.desc = desc;
        this.permission = permission;
    }

    public boolean execute(CommandSender sender, String label, String[] args) {
        if (!sender.hasPermission(this.permission) && this.getPermission() != null) {
            String msg = " &8&l>> &cNie posiadasz uprawnien &8(&7%perm%&8)".replace("%perm%", this.permission);
            msg = msg.replace("{PERM}", this.getPermission());
            MUtil.sendMsg(sender, msg);
            return false;
        } else {
            return this.onExecute(sender, args);
        }
    }

    public abstract boolean onExecute(CommandSender var1, String[] var2);

    public String getName() {
        return this.name;
    }

    public String getUsage() {
        return " &8>> &7Poprawne uzycie: %usage%".replace("%usage%", this.usage);
    }

    public String getDesc() {
        return this.desc;
    }

    public String getPermission() {
        return this.permission;
    }
}
