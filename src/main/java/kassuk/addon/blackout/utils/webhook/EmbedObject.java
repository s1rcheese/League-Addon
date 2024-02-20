package kassuk.addon.blackout.utils.webhook;

import com.google.gson.JsonObject;
import kassuk.addon.blackout.utils.JsonSerializable;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class EmbedObject implements JsonSerializable {
    @Override
    public JsonObject serialize() {
        return new JsonObject();
    }
}