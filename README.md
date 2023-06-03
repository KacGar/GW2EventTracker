
# Guild Wars 2 Event Tracker

Application which allows to check time left for any event available in a game Guild Wars 2 that i play a lot. Application was written purely in JAVA.

## Features

- choosing specific events
- saving events to a file
- loading events from a tile
- shortcuts
- 2 languages available (polish,english)
- start application with favorite events (at default all events are displayed)
- click to copy waypoint codes


## Elaborating more on features
- At default all events are displayed at once
- User can choose specific events from a list if doesn't want to have everything displayed (order in which events were chosen, that will be order in which they will be displayed)
- Save events that are currenty displayed to a .txt file, which can be modified and shared (with few restrictions - event names has to match and every event should be in a new line). 
- At default, saving window will open in user.HOME directory, but nothing stops user to save somewhere else. Next time saving window will open in last saved directory.
- Loading saved events from a file, either from a chosen location or quick load which will be trying to load file from last remembered path
- Change language (polish/english)
- if events were saved to a file, user can choose whether app should start with displaying his favorite events (basically quickloading, in case of an error all events will be displayed), otherwise application will ask user to save events first, then apply this option.
- Shortcuts to display events from a specific game region, display all, quick load or choose events from a list. 
- Events are displayed in a format of tables, which displays name,time left,time when even starts, map and waypoint codes
- User can easly copy waypoint codes by simply clicking on them, it will be saved in a system clipboard

## Libraries

Only one external library is used which is free to use custom Look and Feel API made by FormDev (https://www.formdev.com/flatlaf/) which is not required. In case if library is absent defuault JAVA LaF will be used.
## About

As a begginer in JAVA and programming in general, i do realise code isn't really that good, so please keep in mind that this project was made purely for learning purposes. 
So, although this app checks all my needs, there are already better tools (both in game in form of addons and outside in form of wiki website).
Maybe in future, when i learn more, im gonna rebuild this app (with SOLID,DRY,design patterns etc.)
## Screenshots

[![H42aAdv.md.png](https://iili.io/H42aAdv.md.png)](https://freeimage.host/i/H42aAdv)
[![H42aR7R.md.png](https://iili.io/H42aR7R.md.png)](https://freeimage.host/i/H42aR7R)
[![H42a5ep.md.png](https://iili.io/H42a5ep.md.png)](https://freeimage.host/i/H42a5ep)
[![H42aTrJ.md.png](https://iili.io/H42aTrJ.md.png)](https://freeimage.host/i/H42aTrJ)

