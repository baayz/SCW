### Fork
Fork from [OpegitStudio/SCW](https://github.com/OpegitStudio/SCW).

# SCW
Simple DAE2SCW converter and vice versa. Written just for fun in Java.

Since SC games support glTF, there are no reasons to keep this closed-source. This code is licensed under GPLv3, so feel free to do any changes, but don't forget to keep them open-sourced.

Demo video: https://vk.cc/awEpnK

### Features and flaws
1. It supports animations, but you should export them as matrices (not decomposed)
2. It doesn't support collada completely, but works with models expored from blender
3. Materials aren't fully supported
4. It doesn't accept transformations of root armature from blender, so you should specify them directly
5. Maybe some other bugs, you can report them or search for a solution in [Issues](https://github.com/OpegitStudio/SCW/issues)

### How to use it?
Java 9 is required. You can download prebuilt JAR here: https://github.com/daniillnull/scw/releases

#### Converting .scw to .dae
__`> java -jar SCW.jar scw2dae input_file_geo.scw`__

There are some additional parameters that can be specified optionally:

__`> java -jar executable.jar scw2dae -c file_to_combine.scw -m file_materials.scw -v ver -o output_file.scw input_file.scw`__

`-c` will load another file and combine NODE part with the main file.

`-m` will load another file and add MATE parts to the main file.

`-v` will force the use of a specific scw version for decoding, available versions are 0, 0.25, 0.5, 1, 1.25 and 2.

`-o` will save the file in the desired path.

#### Converting .dae to .scw
Simple way:

__`> java -jar SCW.jar dae2scw input_file.dae`__

There are some additional parameters that can be specified optionally:

__`> java -jar SCW.jar dae2scw -s X;Y;Z -r X;Y;Z -t X;Y;Z -a MGAC -v ver -o output_file.scw input_file.dae`__

`-s`  `-r` `-t` will set transformations for root nodes. They are scale, rotate and translate respectively.

`-a` will set what to export. It can be **M**aterial, **G**eometry, **A**nimation and **C**amera.

`-v` will force the use of a specific scw version for encoding, available versions are 0, 0.25, 0.5, 1, 1.25 and 2 (default is 2).

`-o` will save the file in the desired path.

### Credits
LibGDX: https://github.com/libgdx/libgdx - Used some classes for working with matrices

Thanks [@MICRDEV](https://github.com/MICRDEV) for helping with the research of SC3D format
