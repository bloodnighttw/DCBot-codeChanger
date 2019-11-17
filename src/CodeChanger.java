import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CodeChanger extends ListenerAdapter {

    public String messange="";
    public int language;

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e){

        //new setActive().onGuildMessageReceived(e);

        String[] args=e.getMessage().getContentRaw().split(" ");
        if(args[0].equals(config.perfix+"input")){

            onInputCommand(e,args);

        }else if(args[0].equals(";compile")){
            return;
        }
        else if(args[0].equals("-game")){


        }
        else {

            onFindCodeEvent(e);

        }

    }

    void onInputCommand(GuildMessageReceivedEvent e,String[] args){
        String lang="",cache="";
        if(language == 1)
            lang="c";
        else if(language == 2)
            lang="c++";
        else if(language == 3)
            lang="java";

        for(int i=1;i<args.length;i++)
            cache=cache+" "+args[i];
        e.getChannel().sendMessage("請複製下面機器人所述並貼上").queue();
        e.getChannel().sendTyping().queue();
        e.getChannel().sendMessage(";compile "+lang+" | "+cache+"~~```~~"+messange+"~~```~~").queue();


    }

    void onFindCodeEvent(GuildMessageReceivedEvent e){
        int language=0;
        int langAmount=3;
        /*
         *-1  -> unknow language
         * 1  -> c
         * 2  -> c++
         * 3  -> java
         * >3 -> unknow language
         */
        String messange=e.getMessage().getContentRaw();

        if(messange.contains("#include <iostream>"))
            language=language*langAmount+2;
        if(messange.contains("void main(String[)"))
            language=language*langAmount+3;
        if(messange.contains("#include <stdio.h>"))
            language=language*langAmount+1;

        switch (language){
            case 1:
                System.out.println("find a c code");
                break;
            case 2:
                System.out.println("find a c++ code");
                break;
            case 3:
                System.out.println("find a java code");
                break;
        }

        boolean isALang=false;

        if(language==1 || language==2 || language==3)
            isALang=true;

        if((!e.getAuthor().isBot()) && isALang)
            e.getChannel().sendMessage("```"+messange+"```").queue();

        if(isALang){
            this.messange=messange;
            this.language=language;

        }


    }



    /*
    public void inputToCompilerBot(GuildMessageReceivedEvent e){
        String st;
        if(language == 1)
            st="java";
        if(language == 2)
            st="c++";
    }

    */
}
