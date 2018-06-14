package ru.mrmilegit.rpgthings.proxy;

import ru.mrmilegit.rpgthings.RpgThings;
import ru.mrmilegit.rpgthings.handlers.ClientPackageHandler;
import ru.mrmilegit.rpgthings.handlers.RpgThingsTickHandler;
import ru.mrmilegit.rpgthings.items.renderer.*;
import ru.mrmilegit.rpgthings.lib.PTTReference;
import ru.mrmilegit.rpgthings.tileentities.*;
import ru.mrmilegit.rpgthings.tileentitiespecialRender.*;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class RpgThingsClientProxy extends RpgThingsCommonProxy {

   public void Init() {
      RpgThings.channel.register(new ClientPackageHandler());
   }

   public void RegisterRenderers() 
   {
	  
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEmeraldOre.class, new TileEntityRenderEmeraldOre());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityObsidianOre.class, new TileEntityRenderObsidianOre());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityN2ObsidianOre.class, new TileEntityRenderN2ObsidianOre());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStarmetalOre.class, new TileEntityRenderStarmetalOre());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAdamantiumOre.class, new TileEntityRenderAdamantiumOre());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAncientgemOre.class, new TileEntityRenderAncientgemOre());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlackrockOre.class, new TileEntityRenderBlackrockOre());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFelslateOre.class, new TileEntityRenderFelslateOre());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLeystoneOre.class, new TileEntityRenderLeystoneOre());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCobaltOre.class, new TileEntityRenderCobaltOre());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElementiumOre.class, new TileEntityRenderElementiumOre());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTrueironOre.class, new TileEntityRenderTrueironOre());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTrilliumOre.class, new TileEntityRenderTrilliumOre());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityThoriumOre.class, new TileEntityRenderThoriumOre());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPyriumOre.class, new TileEntityRenderPyriumOre());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFelironOre.class, new TileEntityRenderFelironOre());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKhoriumOre.class, new TileEntityRenderKhoriumOre());
      MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RpgThings.EmeraldOre), new ItemEmeraldGemRender());
      MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RpgThings.ObsidianOre), new ItemObsidianGemRender());
      MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RpgThings.N2ObsidianOre), new ItemN2ObsidianGemRender());
      MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RpgThings.StarmetalOre), new ItemStarmetalGemRender());
      MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RpgThings.AdamantiumOre), new ItemAdamantiumGemRender());
      MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RpgThings.AncientgemOre), new ItemAncientgemGemRender());
      MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RpgThings.BlackrockOre), new ItemBlackrockGemRender());
      MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RpgThings.FelslateOre), new ItemFelslateGemRender());
      MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RpgThings.LeystoneOre), new ItemLeystoneGemRender());
      MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RpgThings.CobaltOre), new ItemCobaltGemRender());
      MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RpgThings.ElementiumOre), new ItemElementiumGemRender());
      MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RpgThings.TrueironOre), new ItemTrueironGemRender());
      MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RpgThings.TrilliumOre), new ItemTrilliumGemRender());
      MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RpgThings.ThoriumOre), new ItemThoriumGemRender());
      MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RpgThings.PyriumOre), new ItemPyriumGemRender());
      MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RpgThings.FelironOre), new ItemFelironGemRender());
      MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RpgThings.KhoriumOre), new ItemKhoriumGemRender());
   }

   public void registerTicks() {
      FMLCommonHandler.instance().bus().register(new RpgThingsTickHandler(false));
   }

}
