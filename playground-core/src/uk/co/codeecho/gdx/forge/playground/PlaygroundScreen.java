package uk.co.codeecho.gdx.forge.playground;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import uk.co.codeecho.gdx.forge.GameManager;
import uk.co.codeecho.gdx.forge.action.Action;
import uk.co.codeecho.gdx.forge.box2d.collision.event.PreCollisionEvent;
import uk.co.codeecho.gdx.forge.box2d.collision.event.PreCollisionEventListener;
import uk.co.codeecho.gdx.forge.box2d.debug.Box2DDebugRenderer;
import uk.co.codeecho.gdx.forge.box2d.fixture.filter.ComponentFixtureFilter;
import uk.co.codeecho.gdx.forge.box2d.fixture.filter.ComponentTypeFixtureFilter;
import uk.co.codeecho.gdx.forge.box2d.world.WorldBuilder;
import uk.co.codeecho.gdx.forge.box2d.world.WorldStepAction;
import uk.co.codeecho.gdx.forge.camera.StandardCamera;
import uk.co.codeecho.gdx.forge.component.builder.ComponentBuilderFactory;
import uk.co.codeecho.gdx.forge.input.touch.TouchUpEvent;
import uk.co.codeecho.gdx.forge.input.touch.TouchUpEventListener;
import uk.co.codeecho.gdx.forge.library.component.Block;
import uk.co.codeecho.gdx.forge.library.event.box2d.Box2dTouchListener;
import uk.co.codeecho.gdx.forge.library.event.box2d.FixtureTouchUpEvent;
import uk.co.codeecho.gdx.forge.library.event.box2d.FixtureTouchUpEventListener;
import uk.co.codeecho.gdx.forge.library.event.listener.SpriteBatchEventListener;
import uk.co.codeecho.gdx.forge.library.scene2d.Scene2DRenderer;
import uk.co.codeecho.gdx.forge.playground.ball.Ball;
import uk.co.codeecho.gdx.forge.playground.ball.BallViewModel;
import uk.co.codeecho.gdx.forge.playground.player.Player;
import uk.co.codeecho.gdx.forge.playground.player.PlayerComponentBuilder;
import uk.co.codeecho.gdx.forge.screen.Screen;
import uk.co.codeecho.gdx.forge.tmx.TMXMapBuilder;
import uk.co.codeecho.gdx.forge.tmx.TMXMapBuilderImpl;

public class PlaygroundScreen extends Screen {

    private final World world;

    private final Block goButton;
    private final Block throwButton;
    
    private final Player player1;
    private final Player player2;
    
    private final Ball ball;

    private boolean throwButtonEnabled = false;

    public PlaygroundScreen() {
        SpriteBatch spriteBatch = new SpriteBatch();
        world = new WorldBuilder().build();

        addAction(new WorldStepAction(world));

        TiledMap map = new TmxMapLoader().load("cortex.tmx");

        GameManager gameManager = GameManager.getInstance();

        StandardCamera camera = new StandardCamera();

        Scene2DRenderer scene2dRenderer = new Scene2DRenderer(spriteBatch);
        
        ComponentBuilderFactory componentBuilderFactory = new PlaygroundComponentBuilderFactory(spriteBatch, world, scene2dRenderer);
        TMXMapBuilder mapBuilder = new TMXMapBuilderImpl(map, componentBuilderFactory, camera, spriteBatch);
        addLayers(mapBuilder.build());

        goButton = (Block) getComponent("goButton");
        throwButton = (Block) getComponent("throwButton");

        player1 = new PlayerComponentBuilder(world, spriteBatch)
                .setPosition(2, 6).build();
        addComponent(player1);
        
        player2 = new PlayerComponentBuilder(world, spriteBatch)
                .setPosition(2, 4).build();
        addComponent(player2);

        ball = new Ball(new BallViewModel(world, 0.1f));
        ball.setPosition(new Vector2(-10, -10));
        addComponent(ball);
        
        player1.takeBall(ball);

        addComponent(new SpriteBatchEventListener(spriteBatch, camera));

        if (gameManager.isDebugMode()) {
            addComponent(new Box2DDebugRenderer(world, camera, spriteBatch));
        }

        addEventListeners();
    }

    private void addEventListeners() {
        addEventListener(new Box2dTouchListener(world, this));
        addEventListener(new FixtureTouchUpEventListener(new ComponentFixtureFilter(throwButton)) {

            @Override
            public void doHandle(FixtureTouchUpEvent event) {
                throwButtonEnabled = !throwButtonEnabled;
            }
        });
        addEventListener(new FixtureTouchUpEventListener(new ComponentFixtureFilter(goButton)) {

            @Override
            public void doHandle(FixtureTouchUpEvent event) {
                player1.act();
            }
        });
        addEventListener(new TouchUpEventListener() {

            @Override
            public void doHandle(TouchUpEvent event) {
                if (throwButtonEnabled) {
                    player1.addThrowAction(event.getCoordinates());
                    throwButtonEnabled = false;
                } else {
                    player1.addMoveAction(event.getCoordinates());
                }
            }
        });
        addEventListener(new PreCollisionEventListener(new ComponentFixtureFilter(ball), new ComponentTypeFixtureFilter(Player.class)) {
            
            @Override
            public void doHandle(PreCollisionEvent event) {
                addAction(new Action() {

                    @Override
                    public boolean invoke(float delta) {
                        ball.setPosition(new Vector2(-10, -10));
                        return true;
                    }
                });
                Player player = (Player) event.getCollision().getTargetComponent();
                player.takeBall(ball);
                event.getCollision().cancel();
            }
        });
    }

}
