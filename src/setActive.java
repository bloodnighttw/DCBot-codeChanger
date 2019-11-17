
import com.Bloodnight.JDATool.CommandSystem.Command;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class setActive extends Command {

    @Override
    public String getCommandName() {
        return "=ht";
    }

    @Override
    public String getDescription() {
        return "nothing";
    }

    @Override
    public void onCommand(GuildMessageReceivedEvent e,String[] args){
        System.out.println("hi");
    }


}
