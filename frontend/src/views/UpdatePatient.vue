<template>
  <main>
    <NavBar />
    <div class="my-5 mx-auto w-25" style="max-width: 100%">
      <h2 class="text-center mb-3">Update Patient</h2>
      <form @submit.prevent="updatePatient">
        <!-- Name -->
        <div class="row">
          <div class="col-md-12 form-group mb-3">
            <label for="name" class="form-label">Name</label>
            <input
              type="text"
              name="name"
              id="name"
              class="form-control"
              placeholder="Name"
              v-model="patient.name"
              required
            />
          </div>
        </div>

        <!-- Email -->
        <div class="row">
          <div class="col-md-12 form-group mb-3">
            <label for="email" class="form-label">E-mail</label>
            <input
              type="email"
              name="email"
              id="email"
              class="form-control"
              placeholder="patient@email.com"
              v-model="patient.email"
              required
            />
          </div>
        </div>

        <div class="row">
          <div class="col-md-12 form-group mb-3">
            <label for="pno" class="form-label">Phone Number</label>
            <input
              type="tel"
              name="pno"
              id="pno"
              patter="[0-9]{3}-[0-9]{2}-[0-9]{3}"
              class="form-control"
              placeholder="123-45-789"
              v-model="patient.email"
              required
            />
          </div>
        </div>
      </form>
    </div>
  </main>
</template>

<script>
import NavBar from "../components/NavBar.vue";
export default {
  name: "UpdatePatient",
  components: {
    NavBar,
  },

  data() {
    return {
      patient: {
        id: "",
        name: "",
        email: "",
        pno: "",
        gender: "",
      },
    };
  },

  methods: {
    getPatient() {
      fetch(`http://localhost:8080/patient/${this.$router.id}`)
        .then((res) => res.json)
        .then((data) => {
          this.patient = data;
          console.log(this.patient);
        });
    },

    updatePatient() {
      fetch("http://localhost:8080/patient", {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(this.patient),
      }).then((data) => {
        console.log(this.data);
        this.$router.push("/");
      });
    },
  },
};
</script>
