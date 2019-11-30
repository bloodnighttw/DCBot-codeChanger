
import com.Bloodnight.JDATool.CommandSystem.Command;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class setActive extends Command {

    @Override
    public String getCommandName() {
        return "=cg";
    }

    @Override
    public String getDescription() {
        return "nothing";
    }

    @Override
    public void onCommand(GuildMessageReceivedEvent e,String[] args){
        try {
            Main.getJda().getPresence().setActivity(Activity.playing(args[1]));
        }
        catch (Exception expection){
            return;
        }
        //System.out.println("hi");
    }


}
