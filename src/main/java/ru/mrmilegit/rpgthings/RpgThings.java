package ru.mrmilegit.rpgthings;

import ru.mrmilegit.rpgthings.block.*;
import ru.mrmilegit.rpgthings.handlers.RpgThingsTickHandler;
import ru.mrmilegit.rpgthings.items.RpgThingsBaseItem;
import ru.mrmilegit.rpgthings.proxy.RpgThingsCommonProxy;
import ru.mrmilegit.rpgthings.tileentities.*;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

@Mod(
   modid = "rpgthings",
   name = "Rpg Things",
   version = "3.5"
)
public class RpgThings {

   @Instance("rpgthings")
   public static RpgThings instance;
   @SidedProxy(
      clientSide = "ru.mrmilegit.rpgthings.proxy.RpgThingsClientProxy",
      serverSide = "ru.mrmilegit.rpgthings.proxy.RpgThingsCommonProxy"
   )
   public static RpgThingsCommonProxy proxy;
   public static Block EmeraldOre;
   public static Block ObsidianOre;
   public static Block N2ObsidianOre;
   public static Block StarmetalOre;
   public static Block AdamantiumOre;
   public static Block AncientgemOre;
   public static Block BlackrockOre;
   public static Block FelslateOre;
   public static Block LeystoneOre;
   public static Block CobaltOre;
   public static Block ElementiumOre;
   public static Block TrueironOre;
   public static Block TrilliumOre;
   public static Block ThoriumOre;
   public static Block PyriumOre;
   public static Block FelironOre;
   public static Block KhoriumOre;
   public static final String networkChannelName = "RpgThingsGeneral";
   public static FMLEventChannel channel;


   @EventHandler
   public void preInit(FMLPreInitializationEvent event) {
      Configuration config = new Configuration(event.getSuggestedConfigurationFile());
      config.load();
      config.save();
      NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
      instance = this;
   }

   @EventHandler
   public void init(FMLInitializationEvent event) {
      channel = NetworkRegistry.INSTANCE.newEventDrivenChannel("RpgThingsGeneral");
      proxy.Init();
      proxy.registerTicks();
      this.registerBlocks();
      this.registerTileEntities();
      this.registerTickAndEventHandlers();
      proxy.RegisterRenderers();
   }

   private void registerBlocks() {
      EmeraldOre = new BlockEmeraldOre();
      ObsidianOre = new BlockObsidianOre();
      N2ObsidianOre = new BlockN2ObsidianOre();
      StarmetalOre = new BlockStarmetalOre();
      AdamantiumOre = new BlockAdamantiumOre();
      AncientgemOre = new BlockAncientgemOre();
      BlackrockOre = new BlockBlackrockOre();
      FelslateOre = new BlockFelslateOre();
      LeystoneOre = new BlockLeystoneOre();
      CobaltOre = new BlockCobaltOre();
      ElementiumOre = new BlockElementiumOre();
      TrueironOre = new BlockTrueironOre();
      TrilliumOre = new BlockTrilliumOre();
      ThoriumOre = new BlockThoriumOre();
      PyriumOre = new BlockPyriumOre();
      FelironOre = new BlockFelironOre();
      KhoriumOre = new BlockKhoriumOre();
      this.registerBlock(EmeraldOre, "EmeraldOre");
      this.registerBlock(ObsidianOre, "ObsidianOre");
      this.registerBlock(N2ObsidianOre, "N2ObsidianOre");
      this.registerBlock(StarmetalOre, "StarmetalOre");
      this.registerBlock(AdamantiumOre, "AdamantiumOre");
      this.registerBlock(AncientgemOre, "AncientgemOre");
      this.registerBlock(BlackrockOre, "BlackrockOre");
      this.registerBlock(FelslateOre, "FelslateOre");
      this.registerBlock(LeystoneOre, "LeystoneOre");
      this.registerBlock(CobaltOre, "CobaltOre");
      this.registerBlock(ElementiumOre, "ElementiumOre");
      this.registerBlock(TrueironOre, "TrueironOre");
      this.registerBlock(TrilliumOre, "TrilliumOre");
      this.registerBlock(ThoriumOre, "ThoriumOre");
      this.registerBlock(PyriumOre, "PyriumOre");
      this.registerBlock(FelironOre, "FelironOre");
      this.registerBlock(KhoriumOre, "KhoriumOre");
   }

   private void registerTileEntities() {
      GameRegistry.registerTileEntity(TileEntityEmeraldOre.class, "Emerald");
      GameRegistry.registerTileEntity(TileEntityObsidianOre.class, "Obsidian");
      GameRegistry.registerTileEntity(TileEntityN2ObsidianOre.class, "N2Obsidian");
      GameRegistry.registerTileEntity(TileEntityStarmetalOre.class, "Starmetal");
      GameRegistry.registerTileEntity(TileEntityAdamantiumOre.class, "Adamantium");
      GameRegistry.registerTileEntity(TileEntityAncientgemOre.class, "Ancientgem");
      GameRegistry.registerTileEntity(TileEntityBlackrockOre.class, "Blackrock");
      GameRegistry.registerTileEntity(TileEntityFelslateOre.class, "Felslate");
      GameRegistry.registerTileEntity(TileEntityLeystoneOre.class, "Leystone");
      GameRegistry.registerTileEntity(TileEntityCobaltOre.class, "Cobalt");
      GameRegistry.registerTileEntity(TileEntityElementiumOre.class, "Elementium");
      GameRegistry.registerTileEntity(TileEntityTrueironOre.class, "Trueiron");
      GameRegistry.registerTileEntity(TileEntityTrilliumOre.class, "Trillium");
      GameRegistry.registerTileEntity(TileEntityThoriumOre.class, "Thorium");
      GameRegistry.registerTileEntity(TileEntityPyriumOre.class, "Pyrium");
      GameRegistry.registerTileEntity(TileEntityFelironOre.class, "Feliron");
      GameRegistry.registerTileEntity(TileEntityKhoriumOre.class, "Khorium");
   }


   private void registerTickAndEventHandlers() {
      FMLCommonHandler.instance().bus().register(new RpgThingsTickHandler(true));
   }

   @EventHandler
   public void postInit(FMLPostInitializationEvent event) {}

   public void registerBlock(Block block, String unlocalizedName) {
      block.setBlockName(unlocalizedName);
      block.setCreativeTab(RpgThingsCreativeTab.tabRpgthings);
      GameRegistry.registerBlock(block, unlocalizedName);
      block.setBlockTextureName("rpgthings:" + unlocalizedName);
   }
   
   public void registerItem(Item item, String unlocalizedName) {
      item.setUnlocalizedName(unlocalizedName);
      item.setCreativeTab(RpgThingsCreativeTab.tabRpgthings);
      GameRegistry.registerItem(item, unlocalizedName);
      item.setTextureName("rpgthings:" + unlocalizedName);
   }

}
