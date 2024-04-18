//
// Mobスポーンを監視するリスナ
//
package me.enchan.anti_insects;

import java.util.Arrays;

import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.Bukkit;

/**
 * Mobスポーンリスナ
 */
public class MobSpawnListener implements Listener {

    @EventHandler
    public void onSpawnCreature(CreatureSpawnEvent event){
        // スポーンするエンティティタイプとスポーン理由を取得
        EntityType entityType = event.getEntity().getType();
        SpawnReason reason = event.getSpawnReason();

        // 理由の如何によらず、シルバーフィッシュは許可しない
        if(entityType == EntityType.SILVERFISH){
            event.setCancelled(true);
            return;
        }

        // クモ系はスポナーからの湧出のみ許可する
        EntityType spiderTypes[] = {EntityType.SPIDER, EntityType.CAVE_SPIDER};
        if(Arrays.asList(spiderTypes).contains(entityType) && reason != SpawnReason.SPAWNER){
            event.setCancelled(true);
            return;
        }
    }

}
