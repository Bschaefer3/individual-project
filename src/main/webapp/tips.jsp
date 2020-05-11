<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">

<c:import url="template/header.html"/>
<body class="container">

<c:choose>
    <c:when test="${user != null}">
        <c:import url="template/navbar.jsp"/>
    </c:when>
    <c:otherwise>
        <c:import url="template/notLoggedNavBar.jsp"/>
    </c:otherwise>
</c:choose>

<main>
    <div class="row">
        <div class="col-12 text-center">
            <h1>Tips and Tricks</h1>
        </div>
    </div>
    
    <div class="row">
        <div class="col-12 text-center">
            <h3>Set-up</h3>
        </div>
        <div class="col-6">
            Lags and freezes can be deadly, and deaths may completely nullify your progress. You can display an overlay 
            with your current framerate and latency by pressing <code>F1</code>. If you have any issues with game performance,
            try different DirectX component versions and find out which one works best for you. There were also reports
            of <code>"Fullscreen windowed mode"</code> to work better than <code>"Fullscreen mode"</code>. <br> <br>

            Download and use Loot filter (for example <em>Neversink's LootFilter</em> from the official games forum). You
            should eventually find out by yourself which items are valuable and worth picking up, but till then the loot
            filter will hide all the useless stuff.
        </div>
        <div class="col-6">
            <img src="images/necro.png" alt="Path of Exile Necromancer Fan Art" class="rounded img-fluid img-thumbnail">
        </div>
    </div>

    <div class="row">
        <div class="col-12 text-center">
            <h3>General Tips</h3>
        </div>
        <div class="col-6">
            <img src="images/archer.png" alt="Path of Exile Archer Fan Art" class="rounded img-fluid img-thumbnail">
        </div>
        <div class="col-6">
            There are few useful chat commands that include: <br>
            <code>/hideout</code> - teleports you to your hideout (works only while in town or another hideout) <br>
            <code>/passives</code> - shows a summary of all passive points rewards, and the Bandits quests reward the
            character has gained <br>
            <code>/remaining</code> - shows the number of monsters remaining in the area <br> <br>

            You should always level up gems in items you carry in your alternate weapon slots. You can either do it for
            gems that you know you will be using shortly (after you replace your gear, or reach a certain level) or
            Support gems like <code>Empower</code>/<code>Enlighten</code>/<code>Enhance</code> that require a lot of
            experience points to be leveled up. <br> <br>

            When using skills that fire multiple projectiles (or any projectile-based skill that is supported by
            <code>Lesser Multiple Projectiles</code> or <code>Greater Multiple Projectiles</code>) can be either aimed
            close to your character, making the projectiles to be more spread out and cover wide areas or aimed further
            away, and the projectiles will be fired in a nearly straight line.
        </div>
    </div>

    <div class="row">
        <div class="col-12 text-center">
            <h3>Leveling</h3>
        </div>
        <div class="col-12">
            Don't worry much about choosing a wrong character class, unless you knew for certain what type of build you
            wanted to play, and you want to maximize its potential. In general, Path of Exile provides the highest
            flexibility when it comes to building your character. You can build powerful Witches or Duelist that wield
            bows, spell caster Berserkers or tanky Shadow class characters - everything is possible in Path of Exile,
            and unlike other games, still may remain viable if planned well. <br> <br>

            Never consume/use currency items (except for <code>Portal Scrolls</code>, <code>Scrolls of Wisdom</code>,
            <code>Blacksmith's Whetstones</code>, <code>Armourer's Scraps</code> which are rather inexpensive) while
            leveling your character. Unless these are the first days of a new League when good leveling items are hard
            to get, using orbs to upgrade or craft items is extremely expensive. <br> <br>

            You should consider buying leveling unique items that are most suitable for your character class.
            As stated earlier, unless this is the first days of a new League, most of this shouldn't be expensive and
            will save you a lot of time. <br>
            <code>Goldrim</code> - Increased elemental resistances <br>
            <code>Tabula Rasa</code> - Instant 6 Link <br>
            <code>Seven League Step</code> - Insane movement speed <br>
            <code>Atziri's Foible</code> - Increased Mana Regeneration <br>
        </div>
        <div class="col">
            <img src="images/goldrim.png" alt="Path of Exile - Goldrim Unique" class="rounded img-fluid img-thumbnail">
        </div>
        <div class="col">
            <img src="images/tabula.png" alt="Path of Exile - Tabula Rasa Unique" class="rounded img-fluid img-thumbnail">
        </div>
        <div class="col">
            <img src="images/seven.png" alt="Path of Exile - Seven League Step Unique" class="rounded img-fluid img-thumbnail">
        </div>
        <div class="col">
            <img src="images/foible.png" alt="Path of Exile - Atziri's Foible Unique" class="rounded img-fluid img-thumbnail">
        </div>
    </div>
</main>

<c:import url="template/footer.html"/>

</body>
</html>
