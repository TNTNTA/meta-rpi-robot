DESCRIPTION = "core-image-base for rpi robot"
LICENSE = "MIT"

#require recipes-core/images/core-image-base.bb
inherit core-image

IMAGE_FSTYPES = "ext4.xz rpi-sdimg"
SDIMG_ROOTFS_TYPE="ext4.xz"

DISTRO_FEATURES:append = " opengl"
DISTRO_FEATURES:remove = " x11"

IMAGE_FEATURES += "ssh-server-openssh"

IMAGE_INSTALL +=" \
	packagegroup-rpi-robot \
	packagegroup-ros \
	packagegroup-qt5 \
"
