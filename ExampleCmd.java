public class ExampleCmd extends Command {
    public EcCmd() {
        super("nazwa", "Opis", "Uzycie","permisja", new String[]{"aliasy"});
    }

    @Override
    public boolean onExecute(CommandSender sender, String[] args) {
        //Kod komendy
        return false;
    }
}
