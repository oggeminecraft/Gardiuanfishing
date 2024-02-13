// ExampleMod.java
public class ExampleMod {
    // Forge event handler for fishing
    @SubscribeEvent
    public void onFishing(FishingEvent event) {
        if (!event.getWorld().isRemote()) { // Ensure server-side processing
            if (event.getEntityPlayer() != null && event.getEntityPlayer().isEntityAlive()) {
                // Check if the fishing is happening in an open ocean biome
                if (isInOpenOceanBiome(event.getEntityPlayer())) {
                    // Determine whether to spawn a guardian entity based on chance
                    if (event.getWorld().rand.nextInt(20) == 0) { // 1/20 chance
                        // Spawn a guardian entity near the player's location
                        EntityGuardian guardian = new EntityGuardian(event.getWorld());
                        guardian.setPosition(event.getEntityPlayer().posX, event.getEntityPlayer().posY, event.getEntityPlayer().posZ);
                        event.getWorld().spawnEntity(guardian);
                    }
                }
            }
        }
    }

    // Method to check if the player is in an open ocean biome
    private boolean isInOpenOceanBiome(EntityPlayer player) {
        Biome biome = player.world.getBiome(player.getPosition());
        return biome == Biomes.OCEAN || biome == Biomes.DEEP_OCEAN || biome == Biomes.FROZEN_OCEAN;
    }
}
