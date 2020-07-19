package io.libsoft.asteroids.model;

import io.libsoft.messenger.GameState;
import java.util.UUID;
import javafx.beans.property.SimpleObjectProperty;

public class InternalModel {


  private GameState gameState;
  private final SimpleObjectProperty<UUID> uuid;
  private String username;
  private double tickSpeed;
  private long prev = 0;

  private InternalModel() {
    uuid = new SimpleObjectProperty<>(null);
  }


  public SimpleObjectProperty<UUID> uuidProperty() {
    return uuid;
  }

  public void setUUID(UUID uuid) {
    this.uuid.set(uuid);
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public static InternalModel getInstance() {
    return InternalModel.InstanceHolder.INSTANCE;
  }

  public UUID getUUID() {
    return uuid.get();
  }

  public void setGameState(GameState gameState) {
    this.gameState = gameState;
  }



  public GameState getGameState() {
    return gameState;
  }

  public void timestampUpdate(long nanoTime) {
    tickSpeed = 1/((nanoTime - prev) / 1e9);
    prev = nanoTime;
  }

  public double getTickSpeed() {
    return tickSpeed;
  }

  private static class InstanceHolder {

    private static final InternalModel INSTANCE;

    static {
      INSTANCE = new InternalModel();
    }

  }


}
