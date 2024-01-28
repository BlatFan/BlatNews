package ru.blatfan.blatnews;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import ru.blatfan.blatlibs.book.BookUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Config config = BlatNews.config;
        List<String> texts = new ArrayList<>();
        try {
            texts = Files.readAllLines(new File(BlatNews.blatNews.getDataFolder(), "news.txt").toPath());
        } catch (IOException ignore) {}
        ItemStack book = BookUtil.writtenBook()
                .author(config.getString("book-author"))
                .title(config.getString("book-title"))
                .pagesRaw(texts)
                .build();
        if(config.getBoolean("book-open-message.enable")) event.getPlayer().sendMessage(config.getString("book-open-message.text"));
        BookUtil.openPlayer(event.getPlayer(), book);
    }

}
