package daniillnull.scw.sections.subs;

import daniillnull.scw.ScwSerializableEntity;
import daniillnull.scw.util.ScwInputStream;
import daniillnull.scw.util.ScwOutputStream;

import java.io.IOException;

public class ScwBoneWeights implements ScwSerializableEntity {
	public final int[] joints;
	public final float[] weights;

	public ScwBoneWeights() {
		joints = new int[4];
		weights = new float[4];
	}

	@Override
	public void load(ScwInputStream is) throws IOException {
		joints[0] = is.readUnsignedByte();
		joints[1] = is.readUnsignedByte();
		joints[2] = is.readUnsignedByte();
		joints[3] = is.readUnsignedByte();
		if (is.getConfig().version < 0.5) {
			weights[0] = is.readUnsignedByte() / 255f;
			weights[1] = is.readUnsignedByte() / 255f;
			weights[2] = is.readUnsignedByte() / 255f;
			weights[3] = is.readUnsignedByte() / 255f;
		} else {
			weights[0] = is.readUnsignedShort() / 65535f;
			weights[1] = is.readUnsignedShort() / 65535f;
			weights[2] = is.readUnsignedShort() / 65535f;
			weights[3] = is.readUnsignedShort() / 65535f;
		}
	}

	@Override
	public void save(ScwOutputStream os) throws IOException {
		os.write(joints[0]);
		os.write(joints[1]);
		os.write(joints[2]);
		os.write(joints[3]);
		if (os.getConfig().version < 0.5) {
			os.write(Math.round(weights[0] * 255));
			os.write(Math.round(weights[1] * 255));
			os.write(Math.round(weights[2] * 255));
			os.write(Math.round(weights[3] * 255));
		} else {
			os.writeShort(Math.round(weights[0] * 65535));
			os.writeShort(Math.round(weights[1] * 65535));
			os.writeShort(Math.round(weights[2] * 65535));
			os.writeShort(Math.round(weights[3] * 65535));
		}
	}

	public int getUsedJointCount() {
		int jointsCount = 0;
		for (int i = 0; i < 4; i++) {
			if (weights[i] != 0) {
				jointsCount++;
			}
		}
		return jointsCount;
	}
}
