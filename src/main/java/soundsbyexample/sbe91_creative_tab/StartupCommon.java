/*
** User: Paul Boese aka Aeronica
** Date: Sep 10, 2016
**
** Based on MinecraftByExample by TheGreyGhost and others
** https://github.com/TheGreyGhost/MinecraftByExample
*/
package soundsbyexample.sbe91_creative_tab;

public class StartupCommon
{
    public static AllSbeItemsTab allSbeItemsTab;        // holds our custom creative tab displaying all SBE items

    public static void preInitCommon()
    {
        allSbeItemsTab = new AllSbeItemsTab("sbe91_creative_tab_all_SBE");
    }

    public static void initCommon()
    {
    }

    public static void postInitCommon()
    {
    }
}
