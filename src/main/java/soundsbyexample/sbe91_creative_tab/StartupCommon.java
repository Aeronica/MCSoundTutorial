package soundsbyexample.sbe91_creative_tab;

/*
* User: Paul Boese aka Aeronica
* Date: Sep 10, 2016
*
* Based on MinecraftByExample by TheGreyGhost and others
* https://github.com/TheGreyGhost/MinecraftByExample
*/
public class StartupCommon
{
    // holds our custom creative tab displaying all SBE items
    public static AllSbeItemsTab allSBEItemsTab;

    public static void preInitCommon()
    {
        allSBEItemsTab = new AllSbeItemsTab("sbe91_creative_tab_all_SBE");
    }

    public static void initCommon()
    {
    }

    public static void postInitCommon()
    {
    }
}
