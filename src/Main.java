import com.Bloodnight.JDATool.CommandSystem.CommandManager;
import com.Bloodnight.JDATool.toolLoader;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {

    private static JDA jda;

    public static JDA getJda(){
        return jda;
    }

    //public JDA jda;

    public static void main(String[] args) throws LoginException {
        JDABuilder jdaBuilder=new JDABuilder("NDc5OTg1NDI1MTUxNDI2NTcz.XeItUA.Q1R_4835JaztX0QPZI9vRO-kO2c");
        jda=  jdaBuilder.build();
        jda.addEventListener(new CodeChanger());

        toolLoader tl=new toolLoader(jda);
        //CommandManager.addCommand(new setActive());
        CommandManager cm=new CommandManager(jda);


        cm.addCommand(new setActive());
    }
}
