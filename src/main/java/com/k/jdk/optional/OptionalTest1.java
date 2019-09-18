package com.k.jdk.optional;

import jodd.format.RomanNumber;

import java.util.Optional;

/**
 * 使用optional消除空指针异常
 * created by wyk
 * 2018/7/27
 **/
public class OptionalTest1 {

	public static void main(String[] args) {
		Optional<Object> empty = Optional.empty();
		//用isPresent判断和if else没区别
		System.out.println(empty.isPresent());
		String a= null;
		String s = Optional.ofNullable(a).orElse("11111");
		System.out.println(s);

		String s1 = Optional.ofNullable(a).orElseGet(() -> {
			return "abc".toUpperCase();
		});
		System.out.println(s1);

		String s3 = Optional.ofNullable(a).map((s2) -> {
			return "2222".toUpperCase();
		}).orElse("333");

		System.out.println(s3);

		String s4 = Optional.ofNullable("").filter((s2) -> {
			return true;
		}).get();

		System.out.println(s4);


		Optional<String> op = Optional.ofNullable(a);

		boolean equals = op.equals(Optional.empty());


		System.out.println(equals);

		Address address = new Address();
		Building building = new Building();
		Room room = new Room();
		room.setName("room name");
		building.setRoom(room);
		address.setBuilding(building);

		String defaultRoomName = Optional.ofNullable(address)
				//map操作不会引发NPE!
				.map((ad) -> ad.getBuilding())
				.map((bu) -> bu.getRoom())
				.map((rom) -> rom.getName()).orElse("default room name");
    	System.out.println(defaultRoomName);

		test1();
	}

	static class Building{
		private Room room;

		public Room getRoom() {
			return room;
		}

		public void setRoom(Room room) {
			this.room = room;
		}
	}

	static class Room{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	static class Address{
		private Building building;

		public Building getBuilding() {
			return building;
		}

		public void setBuilding(Building building) {
			this.building = building;
		}
	}

	public static void test1(){
		Optional<Room> room = Optional.ofNullable(new Room());
		Optional<String> s = room.flatMap((r) -> Optional.ofNullable(r.getName()));
    	System.out.println(s);
	}
}
