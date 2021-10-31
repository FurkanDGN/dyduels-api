# DYDuels API

## Clone & Install
The following steps will ensure your project is cloned and installed properly.

1. `git clone https://github.com/FurkanDGN/dyduels-api.git`
2. `cd dyduels-api`
3. `mvn install`

## How to Use

### Add plugin.yml Dependency

```yaml
depend: [DYDuels]
```

### API Usage

```java
DYDuels api = null;
Plugin plugin = Bukkit.getPluginManager().getPlugin("DyDuels");
if (plugin != null && plugin.isEnabled()) {
    api = (DYDuels) plugin;
    
    KitManager kitManager = api.getKitManager();
    ArenaManager arenaManager = api.getArenaManager();
    SpectateManager spectateManager = api.getSpectateManager();
    UserManager userManager = api.getUserManager();
}
```